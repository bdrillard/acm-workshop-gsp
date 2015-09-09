(ns acm-workshop-gsp.handler
  (:require [compojure.core :refer [defroutes routes]]
            [ring.middleware.resource :refer [wrap-resource]]
            [ring.middleware.file-info :refer [wrap-file-info]]
            [ring.middleware.params :as params]
            [hiccup.middleware :refer [wrap-base-url]]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [acm-workshop-gsp.routes.home :refer [home-routes]]))

(defn init []
  (println "acm-worksop-gsp is starting"))

(defn destroy []
  (println "acm-workshop-gsp is shutting down"))

(defroutes app-routes
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (-> (params/wrap-params (routes home-routes app-routes))
      (handler/site)
      (wrap-base-url)))
