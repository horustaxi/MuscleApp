import { StyleSheet } from "react-native";

export default (styles = StyleSheet.create({
  viewContainer: {
    flex: 1,
    alignItems: "center",
    width: "100%"
  },
  appLogoContainer: {
    flex: 8,
    justifyContent: "center",
    alignItems: "center"
  },
  appLogo: {
    height: 200,
    width: 200
  },
  textLogo: {
    color: "#FFF",
    fontSize: 50
  },
  form: {
    flex: 6,
    justifyContent: "flex-start",
    width: "100%"
  },
  input: {
    width: "100%",
    fontSize: 20,
    color: "#FFF"
  }
}));
