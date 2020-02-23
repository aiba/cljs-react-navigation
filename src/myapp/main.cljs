(ns myapp.main
  (:require ["react-native" :as rn]
            [applied-science.js-interop :as j]
            [hx.react :as hx]
            [myapp.nav.core :as nav]))

(defonce *root-wrapper (atom nil))

(hx/defcomponent RootWrapper
  (constructor [this]
    this)
  (componentDidMount [this]
    (reset! *root-wrapper this))
  (componentWillUnmount [this]
    (reset! *root-wrapper nil))
  (render [this]
    [nav/NavRoot]))

(defn start {:dev/after-load true} []
  (if-let [rw @*root-wrapper]
    (j/call rw :forceUpdate)
    (rn/AppRegistry.registerComponent "MyApp" (fn [] RootWrapper))))

(defn init []
  (start))
