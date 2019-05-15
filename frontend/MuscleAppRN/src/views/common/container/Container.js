import React from "react";
import { View, Text, StyleSheet } from "react-native";
import { Header } from "react-native-elements";

const HeaderCenter = ({ title }) => (
  <Text style={styles.headerCenterTextStyle}>{title}</Text>
);

const Container = ({ hasHeader = true, headerTitle, children, style }) => {
  return (
    <>
      {hasHeader && (
        <Header
          centerComponent={<HeaderCenter title={headerTitle} />}
          containerStyle={styles.headerContainerStyle}
          barStyle="light-content"
          statusBarProps={{ translucent: true }}
        />
      )}
      <View
        style={[styles.container, { paddingTop: hasHeader ? 0 : 50, ...style }]}
      >
        {children}
      </View>
    </>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    flexDirection: "column",
    justifyContent: "space-between",
    paddingHorizontal: 10,
    backgroundColor: "#333"
  },
  headerContainerStyle: {
    backgroundColor: "#000",
    borderBottomWidth: 0
  },
  headerCenterTextStyle: { color: "#FFF", fontSize: 16 }
});

export default Container;
