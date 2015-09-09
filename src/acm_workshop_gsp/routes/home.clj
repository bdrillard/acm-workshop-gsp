(ns acm-workshop-gsp.routes.home
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [acm-workshop-gsp.views.layout :as layout]))

(defn make-nav [left right]
   [:div.navbar.navbar.default.col-xs-8.col-xs-offset-2
    [:a.btn.btn-primary {:href (str "/" left) :style "margin:8px"} "Prev Slide"]
    [:a.pull-right.btn.btn-primary {:href (str "/" right) :style "margin:8px"} "Next Slide"]])

(defn make-body [& body]
  (into [:div.col-xs-6.col-xs-offset-3] body))

(def slides
  {:1 [:div
       (make-nav nil 2)
       (make-body
         [:h1.text-center "Putting Yourself Out There"]
         [:h3.text-center "An Overview of Static Pages and Generators"]
         [:img.center-block {:src "/img/octocat.png"}]
         [:h3.text-center "Aleksander Eskilson"]
         [:h3.text-center [:a {:href "http://github.com/bdrillard/acm-workshop-gsp"} "github.com/bdrillard/acm-workshop-gsp"]])]
   :2 [:div
       (make-nav 1 3)
       (make-body
         [:h1.text-center "Static as in.. Doesn't Change?"]
         [:p "(Go ahead and create a Github account if you don't have one)"]
         [:p "Sometimes our problem is simple - present information, perhaps for a single user"]
         [:p "Static Pages and Generators are handy"]
         [:ul
          [:li "Full frameworks are big (Ruby on Rails, Django, Drupal)"]
          [:li "Buying space for non-dynamic content seems wasteful"]
          [:li "Its always nice to minimize direct contact with servers..."]])]
   :3 [:div
       (make-nav 2 4)
       (make-body
         [:p.text-center "they're sad"]
         [:img.center-block {:src "/img/sadserver.png"}])]
   :4 [:div
       (make-nav 3 5)
       (make-body
         [:h1.text-center "Github for Hosting"]
         [:p "Asking Github host our content is easy"]
         [:p "Let's start by creating our directory:"]
         [:pre
          [:code "$> mkdir username.github.io"]
          [:code "$> cd username.github.io"]
          [:code "$> echo \"Hello, world!\" > index.html"]])]
   :5 [:div
       (make-nav 4 6)
       (make-body
         [:h1.text-center "Github for Hosting Cont."]
         [:p "Now let's make our repository on Github"]
         [:ol 
          [:li"Go to your Github profile page"]
          [:li "Click on the 'Repositories' tab"]
          [:li "Select 'New' in the upper right hand of the repo listing"]]
         [:img.center-block {:src "/img/createrepo.png"}]
         )]
   :6 [:div
       (make-nav 5 7)
       (make-body
         [:h1.text-center "Github for Hosting Cont."]
         [:p "Now let's push our repository"]
         [:pre
          [:code "$> git add --all"]
          [:code "$> git commit -m \"committing our first page\""]
          [:code "$> remote add origin https://github.com/username/username.github.io.git"]
          [:code "$> git push -u origin master"]])]
   :7 [:div
       (make-nav 6 8)
       (make-body
         [:h1.text-center "Getting Fancy"]
         [:p "This works great for single, one-off pages"]
         [:p "What if we want a little more publishing functionality?"])]
   :8 [:div
       (make-nav 7 9)
       (make-body
         [:h1.text-center "Static Page Generators"]
         [:blockquote "Definition: A system for converting files of markup into sitemaps."]
         [:ul
          [:li "Simple"]
          [:li "Secure"]
          [:li "Performant"]]
         [:p "Generators are available for any language you might choose:"]
         [:ul
          [:li "Ruby - Jekyll, " [:a {:href "http://jekyllrb.com"} "jekyllrb.com"]]
          [:li "Python - Pelican, " [:a {:href "http://blog.getpelican.com"} "blog.getpelican.com"]]
          [:li "JavaScript - Hexo, " [:a {:href "http://hexo.io"} "hexo.io"]]
          [:li "Java - JBake, " [:a {:href "http://jbake.org"} "jbake.org"]]
          [:li "Haskell - Hakyll, " [:a {:href "http://jaspervdj.be/hakyll"} "jaspervdj.be/hakyll"]]
          [:li "Clojure - Cryogen, " [:a {:href "http://cryogenweb.org"} "cryogenweb.org"]]]
         [:p "From " [:a {:href "http://staticgen.com"} "http://staticgen.com"]])]
   :9 [:div
       (make-nav 8 10)
       (make-body
         [:h1.text-center "Differences"]
         [:p "Generators can have opinions too"]
         [:ul
          [:li "Blogging capability"]
          [:li "Templating language"]
          [:li "Plugins"]
          [:li "Ecosystem (themers, doc, etc)"]
          [:li "Server deployment mode"]
          [:li "License"]])]
   :10 [:div
        (make-nav 9 11)
        (make-body
          [:h1.text-center "Cryogen"]
          [:ol
           [:li 
            [:p "Grab this startup script:"]
            [:blockquote [:a {:href "https://raw.githubusercontent.com/bdrillard/acm-workshop-gsp/master/resources/scripts/lein-script.sh"}"https://raw.githubusercontent.com/bdrillard/acm-workshop-gsp/master/resources/scripts/lein-script.sh"]]]
           [:li 
            [:p "Make it executable, and run it"]
            [:pre
             [:code "$> chmod +x lein-script.sh"]
             [:code "$> ./lein-script.sh"]
             [:code "$> cd my-blog"]]]
           [:li
            [:p "Let's poke around the directories"]
            [:pre
             [:code "$> ls resources"]
             [:code "$> ls resources/templates"]]]
           [:li 
            [:p "Change the value of :blog-prefix to the empty string, change other fields to suit you"]
            [:pre [:code "$> gedit resources/templates/config.edn"]]]
           [:li
            [:p "Test the site"]
            [:pre [:code "$> lein ring server"]]]])]
    :11 [:div
         (make-nav 10 12)
         (make-body
           [:h1.text-center "Whaa?"]
           [:p "Cryogen just compiled the files in our resources/templates/md directory to HTML"]
           [:pre
            [:code "$> ls resources"]]
           [:p "Let's push it to our repo:"]
           [:ol
            [:li 
             [:p "Copy the contents of the 'public' directory into our github repo root"]
             [:pre
              [:code "$> cp -r resources/public/* .."]
              [:code "$> cd .."]]]
            [:li
             [:p "Let's do all the usual repo things"]
             [:pre
              [:code "$> git init"]
              [:code "$> git add --all"]
              [:code "$> git commit -m \"first commit\""]
              [:code "$> git remote add origin https://github.com/bdrillard/bdrillard.github.io.git"]
              [:code "$> git push -u origin master"]]
             [:li
              [:p "Let it settle"]]
             [:li
              [:p "Navigate to " [:a {:href "bdrillard.github.io"} "username.github.com"]]]]]

           )]})

(defn get-slide [slide-num]
  (layout/common (get slides (keyword slide-num))))

(defroutes home-routes
  (GET "/" [] (get-slide "1"))
  (GET "/:slide" [slide] (get-slide slide))
  (route/resources "/")
  (route/not-found "Page not found"))
