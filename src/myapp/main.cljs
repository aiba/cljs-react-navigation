(ns myapp.main
  (:require ["react-native" :as rn]
            [applied-science.js-interop :as j]
            [hx.react :as hx]))

(hx/defnc Root [_]
  [rn/View {:style {:flex 1, :alignItems "center", :justifyContent "center"}}
   [rn/Text {:style {:font-size 36}}
    "Hello World"]])

(defonce *root-wrapper (atom nil))

(hx/defcomponent RootWrapper
  (constructor [this]
    this)
  (componentDidMount [this]
    (reset! *root-wrapper this))
  (componentWillUnmount [this]
    (reset! *root-wrapper nil))
  (render [this]
    [Root]))

(defn start {:dev/after-load true} []
  (if-let [rw @*root-wrapper]
    (j/call rw :forceUpdate)
    (rn/AppRegistry.registerComponent "MyApp" (fn [] RootWrapper))))

(defn init []
  (start))
