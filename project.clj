(defproject acm-workshop-gsp "0.1.0-SNAPSHOT"
  :description "A tutorial on Static Pages in Github and Cryogen"
  :url "https://github.com/bdrillard/acm-workshop-gsp"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.1.6"]
                 [hiccup "1.0.5"]
                 [ring-server "0.3.1"]]
  :plugins [[lein-ring "0.8.12"]]
  :ring {:handler acm-workshop-gsp.handler/app
         :init acm-workshop-gsp.handler/init
         :destroy acm-workshop-gsp.handler/destroy}
  :profiles
  {:uberjar {:aot :all}
   :production
   {:ring
    {:open-browser? false, :stacktraces? false, :auto-reload? false}}
   :dev
   {:dependencies [[ring-mock "0.1.5"] [ring/ring-devel "1.3.1"]]}})
