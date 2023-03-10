(ns org.motform.merge-podcast-feeds.date
  (:import (java.time ZonedDateTime ZoneId)
           (java.time.format DateTimeFormatter)))

(defn parse-RFC1123
  "Return comparable `ZonedDateTime` instance from parsed RFC1123 date string."
  [^String rfc1123-date]
  (let [formatter (DateTimeFormatter/RFC_1123_DATE_TIME)]
    (ZonedDateTime/parse rfc1123-date formatter)))

(defn RFC1123
  "Return string current time formatted per RFC1123."
  []
  (let [formatter (DateTimeFormatter/RFC_1123_DATE_TIME)
        now       (ZonedDateTime/now)]
    (. formatter format now)))

(defn instant->RFC1123 [instant]
  (.. (DateTimeFormatter/RFC_1123_DATE_TIME)
      (withZone (ZoneId/systemDefault))
      (format instant)))
