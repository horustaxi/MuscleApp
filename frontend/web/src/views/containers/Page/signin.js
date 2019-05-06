import React, { useState } from 'react';
import { Link, Redirect } from 'react-router-dom';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import { Input, Checkbox, Button } from 'antd';
import authAction from '../../../redux/auth/actions';
import SignInStyleWrapper from './signin.style';
import logoImage from '../../../image/logo.png';

const SignIn = ({
  login, history, isLoggedIn, error,
}) => {
  const [loginText, setLoginText] = useState('');
  const [passwordText, setPasswordText] = useState('');

  const handleLogin = () => {
    login(loginText, passwordText);
    global.localStorage.getItem('id_token');
    history.push('/dashboard');
  };

  const from = { pathname: '/dashboard' };

  if (isLoggedIn) {
    return <Redirect to={from} />;
  }

  return (
    <SignInStyleWrapper>
      <div className="isoLoginContentWrapper">
        <div className="isoLoginContent">
          <div className="isoLogoWrapper">
            <Link to="/dashboard">
              <img src={logoImage} alt="Smiley face" height="42" width="42" />
              Campo Digital
            </Link>
          </div>
          <div className="wrongCredentials">{error}</div>
          <div className="isoSignInForm">
            <div className="isoInputWrapper">
              <Input
                size="large"
                placeholder="Usuário"
                value={loginText}
                onChange={e => setLoginText(e.target.value)}
              />
            </div>
            <div className="isoInputWrapper">
              <Input
                size="large"
                type="password"
                placeholder="Senha"
                value={passwordText}
                onChange={e => setPasswordText(e.target.value)}
              />
            </div>
            <div className="isoInputWrapper isoLeftRightComponent">
              <Checkbox>Mantenha-me logado</Checkbox>
              <Button type="primary" onClick={handleLogin}>
                Entrar
              </Button>
            </div>
            {/* TODO
            <div className="isoCenterComponent isoHelperWrapper">
              <Link to="" className="isoForgotPass">
                Esqueci minha senha
              </Link>
            </div> */}
          </div>
        </div>
      </div>
    </SignInStyleWrapper>
  );
};

const mapStateToProps = state => ({
  isLoggedIn: state.Auth.get('idToken') !== null,
  error: state.Auth.get('login_error'),
});

const mapDispatchToProps = dispatch => bindActionCreators({ login: authAction.login }, dispatch);

export default connect(
  mapStateToProps,
  mapDispatchToProps,
)(SignIn);
