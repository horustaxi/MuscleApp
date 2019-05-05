import React, { Component } from 'react';
import { Link, Redirect } from 'react-router-dom';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import { Input, Checkbox, Button } from 'antd';
import authAction from '../../redux/auth/actions';
import SignInStyleWrapper from './signin.style';
import logoImage from '../../image/logo.png';

const { login } = authAction;

class SignIn extends Component {
  state = {
    login: '',
    password: '',
  };
  
  handleLogin = () => {
    const { login } = this.props;
    login(this.state.login, this.state.password);
    localStorage.getItem('id_token');
    this.props.history.push('/dashboard');
  };
  render() {
    const from = { pathname: '/dashboard' };

    if (this.props.isLoggedIn) {
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
            <div className="wrongCredentials">{this.props.error}</div>
            <div className="isoSignInForm">
              <div className="isoInputWrapper">
                <Input size="large" placeholder="Usuário"
                  value={this.state.login}
                  onChange={(e) => this.setState({ login: e.target.value })} />
              </div>

              <div className="isoInputWrapper">
                <Input size="large" type="password" placeholder="Senha"
                  value={this.state.password}
                  onChange={(e) => this.setState({ password: e.target.value })}/>
              </div>

              <div className="isoInputWrapper isoLeftRightComponent">
                <Checkbox>
                  Mantenha-me logado
                </Checkbox>
                <Button type="primary" onClick={this.handleLogin}>
                  Entrar
                </Button>
              </div>

              <div className="isoCenterComponent isoHelperWrapper">
                <Link to="" className="isoForgotPass">
                  Esqueci minha senha
                </Link>
              </div>
            </div>
          </div>
        </div>
      </SignInStyleWrapper>
    );
  }
}

const mapStateToProps = (state) => ({  
  isLoggedIn: state.Auth.get('idToken') !== null ? true : false,
  error: state.Auth.get('login_error')
});

const mapDispatchToProps = (dispatch) => bindActionCreators({ login }, dispatch);

export default connect(mapStateToProps, mapDispatchToProps)(SignIn);

// export default connect(
//   state => ({
//     isLoggedIn: state.Auth.get('idToken') !== null ? true : false,
//   }),
//   { login }
// )(SignIn);
