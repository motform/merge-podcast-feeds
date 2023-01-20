(ns org.motform.merge-podcast-feeds.podcast
  (:require [clojure.data.xml :as xml]
            [clojure.string :as str]
            [clojure.spec.alpha :as s]))

;; This should perhaps be populated by some json or xml-file that we eat.
(defn preamble-&-metadata
  "TODO: This should read from a configuration file."
  [build-date]
  (xml/sexp-as-element
   [:rss
    {"version" "2.0"
     "xmlns:content"    "http://purl.org/rss/1.0/modules/content/"
     "xmlns:wfw"        "http://wellformedweb.org/CommentAPI/"
     "xmlns:dc"         "http://purl.org/dc/elements/1.1/"
     "xmlns:atom"       "http://www.w3.org/2005/Atom"
     "xmlns:sy"         "http://purl.org/rss/1.0/modules/syndication/"
     "xmlns:slash"      "http://purl.org/rss/1.0/modules/slash/"
     "xmlns:itunes"     "http://www.itunes.com/dtds/podcast-1.0.dtd"
     "xmlns:googleplay" "http://www.google.com/schemas/play-podcasts/1.0"}
    [:channel
     [:title "Radio åt alla"]
     ["atom:link" {:href "https://radio.alltatalla.se/feed/podcast"
                   :rel "self"
                   :type "application/rss+xml"}]
     [:link "https://radio.alltatalla.se/"]
     [:description "Spretig radio från Förbundet Allt åt alla"]
     [:lastBuildDate build-date]
     [:language "sv-SE"]
     [:copyright "kopimi Allt åt alla"]
     ["itunes:subtitle" "Spretig radio från Förbundet Allt åt alla"]
     ["itunes:author" "Förbundet Allt åt alla"]
     ["itunes:summary" "Spretig radio från Förbundet Allt åt alla"]
     ["itunes:owner"
      ["itunes:name" "Radio åt alla"]
      ["itunes:email" "web@alltatalla.se"]]
     ["itunes:explicit" "clean"]
     ["itunes:image" {:href "https://radio.alltatalla.se/wp-content/uploads/2017/05/logo.png"}]
     [:image
      [:url "https://radio.alltatalla.se/wp-content/uploads/2017/05/logo.png"]
      [:title "Radio åt alla"]
      [:link "https://radio.alltatalla.se/"]]
     ["itunes:category" {:text "News"}
      ["itunes:category" {:text "Politics"}]]
     ["itunes:category" {:text "Society & Culture"}
      ["itunes:category" {:text "News Commentary"}]]
     ["itunes:category" {:text "Government"}
      ["itunes:category" {:text "Non-profit"}]]
     [:generator "org.motform.merge_rss"]]]))
