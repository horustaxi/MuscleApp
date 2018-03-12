'use strict';

import React, { Component } from 'react'
import { Text, View, Image } from 'react-native';
import styles from './styles';
import LoginForm from './LoginForm';

class Login extends React.PureComponent {
    static navigationOptions = {
        title: 'Login',
    };
    render() {
        return(
            <View style={styles.container}>
                <View style={styles.logoContainer}>
                    <Image
                        source={require('../../images/muscleapp_launch_icon.png')}
                        style={styles.logo}/>
                    <Text style={styles.title}>Let's work out!</Text>
                </View>
                <View style={styles.formContainer}>
                    <LoginForm />
                </View>
            </View>
        ); 
    }
}

export default Login;