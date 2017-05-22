(ns build.core
  (:gen-class))

(declare page-head)
(declare page-source)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (spit "reveal/reveal.js-3.5.0/presentation.html"
        (html [:html page-head page-source])))

(def page-head
  [:head
   [:meta {:charset "utf-8"}]
   [:title "Adopting Elixir"]
   [:meta {:name "description" :content "Introducing Elixir to a Team"}]
   [:meta {:name "apple-mobile-web-app-capable" :content "yes"}]
   [:meta {:name "apple-mobile-web-app-status-bar-style" :content "black-translucent"}]
   [:meta {:name "viewport" :content "width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no, minimal-ui"}]
   [:link {:rel "stylesheet" :href "css/reveal.css"}]
   [:link#theme {:rel "stylesheet" :href "css/theme/black.css"}]
   [:link {:rel "stylesheet" :href "lib/css/zenburn.css"}]
   [:script
    "
var link = document.createElement( 'link' );
link.rel = 'stylesheet';
link.type = 'text/css';
link.href = window.location.search.match( /print-pdf/gi ) ? 'css/print/pdf.css' : 'css/print/paper.css';
document.getElementsByTagName( 'head' )[0].appendChild( link );"]])

(def page-source
  [:body
   [:div.reveal
    [:div.slides
     [:section
      [:h1 "Adopting Elixir"]
      [:p "Results from and lessons learned introducing Elixir to a development team"]
      [:p [:small "Created by " [:a "Crispin Wellington"]]]
      [:aside.notes
       [:ul
        [:li "Who am I?"]
        [:li "Head of Software Services @ Simplisite Business Solutions"]
        [:li "Taught myself Erlang in 2008 from Joe Armstrong's book, \"Programming Erlang: Software for a Concurrent World\", 2007"]
        [:li "Then introduced to Clojure by a senior engineer in 2009. Never looked back."]]]]

     [:section
      [:h1 "Tao Te Ching - Lao Tzu"]
      [:p "Those who know, do not talk"]
      [:p "Those who talk, do not know"]
      [:aside.notes
       [:ul
        [:li "notice that I am talking"]
        [:li "therefor it is highly likely I have no idea what I'm talking about"]
        [:li "seek the feedback and opinion of those that do."]]]]

     [:section
      [:h1 "Why Elixir?"]
      [:ul
       [:li "Functional Paradigm"]
       [:li "Immutable Data"]
       [:li "Tooling"]
       [:li "Documentation"]
       [:li "Community and Assistance"]
       [:li "Syntax"]]]

     [:section
      [:h1 "The Team and The Code"]
      [:ul
       [:li "Experience with PHP and C++"]
       [:li "Both mutable, imperative languages"]
       [:li "Issues scaling some C++ 'worker' code"]
       [:li "What do you tell the developers?"]
       [:li "What don't you tell the developers?"]]]

     [:section
      [:h1 "What You Tell"]
      [:ul
       [:li "Map, filter and reduce"]
       [:li "Everything is composed of functions"]
       [:li "Pattern Matching"]
       [:li "PIDs and mail boxes"]]

      [:section
       [:h1 "Old Paradigms to New Paradigms"]
       [:ul
        [:li "Where ever you used to change something..."]
        [:li "Now you return a new thing"]
        [:li "Where ever you used to loop..."]
        [:li "Now you will recurse"]]]]

     [:section
      [:h1 "What You Don't Talk About"]
      [:ul
       [:li "Anything OTP"]
       [:li "Instead, show them how to keep state with recursion"]
       [:li "This is what OTP does under the hood."]
       [:li "They will discover and use OTP in their own time."]
       ]]

     [:section
      [:h1 "The Test Project"]
      [:ul
       [:li "Multithreaded C++"]
       [:li "Handling about 1500 messages per second"]
       [:li "IO bound"]
       [:li "Race conditions and deadlocks"]
       [:li "Database contention"]
       [:li "About 3 months of developer hours"]]]

     [:section
      [:h1 "The Test Project"]
      [:pre "
     211 text files.
     204 unique files.
      69 files ignored.

github.com/AlDanial/cloc v 1.72  T=0.31 s (453.7 files/s, 50920.8 lines/s)
-------------------------------------------------------------------------------
Language                     files          blank        comment           code
-------------------------------------------------------------------------------
C++                             31           1079            287           5151
C/C++ Header                    65            901            415           4247
make                             4            451            272            863
CMake                           33            132             85            678
Bourne Shell                     4             64             80            588
C                                2             96             49            433
JSON                             3              0              0             67
-------------------------------------------------------------------------------
SUM:                           142           2723           1188          12027
-------------------------------------------------------------------------------
"]]

     [:section
      [:h1 "The Elixir Replacement"]
      [:ul
       [:li "Introduced queue"]
       [:li "Broke project into multiple submodule"
        [:ul
         [:li "queue send"]
         [:li "queue worker"]
         [:li "statistics worker"]
         [:li "archive worker"]]]]]

(comment "
$ cloc archiveworker/lib/
      11 text files.
       7 unique files.
       8 files ignored.

github.com/AlDanial/cloc v 1.72  T=0.01 s (436.6 files/s, 51432.2 lines/s)
-------------------------------------------------------------------------------
Language                     files          blank        comment           code
-------------------------------------------------------------------------------
Elixir                           5             96             17            476
-------------------------------------------------------------------------------
SUM:                             5             96             17            476
-------------------------------------------------------------------------------

")

     (comment "
$ cloc queuesend/lib/
      10 text files.
       7 unique files.
       6 files ignored.

github.com/AlDanial/cloc v 1.72  T=0.01 s (376.3 files/s, 36120.5 lines/s)
-------------------------------------------------------------------------------
Language                     files          blank        comment           code
-------------------------------------------------------------------------------
Elixir                           4             62              8            314
-------------------------------------------------------------------------------
SUM:                             4             62              8            314
-------------------------------------------------------------------------------

")

(comment "
$ cloc queueworker/lib/
       8 text files.
       5 unique files.
       3 files ignored.

github.com/AlDanial/cloc v 1.72  T=0.01 s (588.7 files/s, 36500.9 lines/s)
-------------------------------------------------------------------------------
Language                     files          blank        comment           code
-------------------------------------------------------------------------------
Elixir                           5             45             18            247
-------------------------------------------------------------------------------
SUM:                             5             45             18            247
-------------------------------------------------------------------------------

")

     (comment
"
$ cloc statisticsworker/lib/
       9 text files.
       8 unique files.
       2 files ignored.

github.com/AlDanial/cloc v 1.72  T=0.01 s (696.3 files/s, 69430.9 lines/s)
-------------------------------------------------------------------------------
Language                     files          blank        comment           code
-------------------------------------------------------------------------------
Elixir                           7            119             23            556
-------------------------------------------------------------------------------
SUM:                             7            119             23            556
-------------------------------------------------------------------------------

"
       )

     [:section
      [:h1 "The Elixir Replacement"]
      [:pre
       "
      38 text files.
      27 unique files.
      19 files ignored.

github.com/AlDanial/cloc v 1.72  T=0.04 s (594.8 files/s, 56108.0 lines/s)
-------------------------------------------------------------------------------
Language                     files          blank        comment           code
-------------------------------------------------------------------------------
Elixir                          21            322             66           1593
-------------------------------------------------------------------------------
SUM:                            21            322             66           1593
-------------------------------------------------------------------------------
"
       ]]


     [:section
      [:h1 "Results"]
      [:ul
       [:li "12000 lines -> 1600 lines"]
       [:li "1.5k messages/sec -> 65k messages/sec"]
       [:li "180 lock/unlock points -> no locks"]
       [:li "race conditions -> no race conditions"]
       [:li "dead locks -> no dead locks"]
       [:li "3 months -> 1 month"]]
      [:p "Final result: Complete Success"]]

     [:section
      [:h1 "Second Project"]
      [:p "New website. Mostly client side but with a data access layer server side"]
      [:p "Try this new web framework Phoenix"]]


     ]]])
