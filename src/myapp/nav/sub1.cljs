(ns myapp.nav.sub1
  (:require ["@react-navigation/bottom-tabs" :as rnav-tabs]
            ["react-native" :as rn]
            [applied-science.js-interop :as j]
            [myapp.nav.sub2 :as sub2]
            [myapp.util :refer [CenteredView]]
            [hx.react :as hx]))

(defonce tabs-nav (rnav-tabs/createBottomTabNavigator))

(hx/defnc TabA [_]
  [CenteredView
   [rn/Text {:style {:font-size 36}}
    "Tab A"]])

(hx/defnc Root [_]
  (let [{:keys [Navigator Screen]} (j/lookup tabs-nav)]
    [Navigator {}
     [Screen {:name "Tab-A" :component TabA}]
     [Screen {:name "Tab-B" :component sub2/TabB}]]))
