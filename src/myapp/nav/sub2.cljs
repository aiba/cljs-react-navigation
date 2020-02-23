(ns myapp.nav.sub2
  (:require ["react-native" :as rn]
            [hx.react :as hx]
            [myapp.util :refer [CenteredView]]))

(hx/defnc TabB [_]
  [CenteredView
   [rn/Text {:style {:font-size 36}}
    "Tab B"]])
