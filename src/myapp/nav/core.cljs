(ns myapp.nav.core
  (:require ["@react-navigation/native" :refer [NavigationContainer]]
            ["react-native" :as rn]
            [applied-science.js-interop :as j]
            [hx.react :as hx]))

(defn log [& args]
  (j/apply js/console :log (to-array args)))

(defn jpps [x]
  (j/call js/JSON :stringify x nil 2))

(defonce *nav-state (atom nil))

(hx/defnc NavRoot [_]
  [NavigationContainer {:initialState (do (log "initial-state:\n" (jpps @*nav-state))
                                          @*nav-state)
                        :onStateChange (fn [x]
                                         (log "new-state:\n" (jpps x))
                                         (reset! *nav-state x))}
   [rn/View {:style {:flex 1, :alignItems "center", :justifyContent "center"}}
    [rn/Text {:style {:font-size 36}}
     "Hello World!"]]])
