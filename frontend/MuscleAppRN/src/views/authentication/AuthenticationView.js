import React from "react";
import { View, Text, Image } from "react-native";
import { Input, Button } from "react-native-elements";
import logoWhite from "../../resources/assets/logo_white.png";
import styles from "./styles";
import { Container } from "../common";

const FormInput = ({
  placeholder,
  secureTextEntry,
  keyboardType = "default"
}) => (
  <Input
    inputStyle={styles.input}
    placeholder={placeholder}
    placeholderTextColor="#DDD"
    secureTextEntry={secureTextEntry}
    autoCapitalize="none"
    keyboardType={keyboardType}
  />
);

const AuthenticationView = () => {
  return (
    <Container headerTitle="Login" hasHeader={false}>
      <View style={styles.viewContainer}>
        <View style={styles.appLogoContainer}>
          <Image style={styles.appLogo} source={logoWhite} />
          <Text style={styles.textLogo}>MuscleApp</Text>
        </View>
        <View style={styles.form}>
          <FormInput placeholder="Email" keyboardType="email-address" />
          <FormInput placeholder="Senha" secureTextEntry />
          <Button
            buttonStyle={{
              height: 60,
              marginTop: 20,
              backgroundColor: "silver",
              borderRadius: 0
            }}
            titleStyle={{ color: "#000" }}
            title="E N T R A R"
          />
        </View>
      </View>
    </Container>
  );
};

export default AuthenticationView;
