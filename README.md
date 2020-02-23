
## ClojureScript React Native with Shadow, Hx, and React Navigation

An example live-reloading ClojureScript project that combines:

* [react-native](https://facebook.github.io/react-native/)
* [shadow-cljs](http://shadow-cljs.org/)
* [lilactown/hx](https://github.com/Lokeh/hx)
* [react-navigation](https://reactnavigation.org/)

Based on https://github.com/thheller/reagent-react-native/

The more I've been using react native, the more I've come to appreciate
[lilactown/hx](https://github.com/Lokeh/hx) as a thin wrapper over react. [More info here](https://github.com/Lokeh/hx/blob/master/docs/why-not-reagent.md).

### Running

```
$ npx shadow-cljs@2.8.83 watch dev
```

### How the `react-native` folder was created

```
$ npx react-native init MyApp
$ mv MyApp react-native
$ cd react-native
$ yarn add react-native-reanimated react-native-gesture-handler react-native-screens react-native-safe-area-context @react-native-community/masked-view @react-navigation/native @react-navigation/stack @react-navigation/bottom-tabs
$ cat > index.js <<EOF
import "./target/index.js";
EOF
```
