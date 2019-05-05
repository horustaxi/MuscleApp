import React, { Component } from 'react';
import { Route } from 'react-router-dom';
import asyncComponent from '../../helpers/AsyncFunc';

const routes = [
  {
    path: '',
    component: asyncComponent(() => import('../dashboard')),
  },
  {
    path: 'admin-empresa',
    component: asyncComponent(() => import('../AdminEmpresa')),
  },
  {
    path: 'admin-empresa/new',
    component: asyncComponent(() => import('../AdminEmpresa/new')),
  },
  {
    path: 'admin-empresa/empresa/:id',
    component: asyncComponent(() => import('../AdminEmpresa/edit')),
  },
  {
    path: 'admin-filial',
    component: asyncComponent(() => import('../AdminFilial')),
  },
  {
    path: 'admin-filial/new',
    component: asyncComponent(() => import('../AdminFilial/new')),
  },
  {
    path: 'admin-filial/filial/:id',
    component: asyncComponent(() => import('../AdminFilial/edit')),
  },
  {
    path: 'admin-cargo',
    component: asyncComponent(() => import('../AdminCargo')),
  },
  {
    path: 'admin-cargo/new',
    component: asyncComponent(() => import('../AdminCargo/new')),
  },
  {
    path: 'admin-cargo/cargo/:id',
    component: asyncComponent(() => import('../AdminCargo/edit')),
  },
  {
    path: 'admin-usuario',
    component: asyncComponent(() => import('../AdminUsuario')),
  },
  {
    path: 'admin-usuario/new',
    component: asyncComponent(() => import('../AdminUsuario/new')),
  },
  {
    path: 'admin-usuario/usuario/:id',
    component: asyncComponent(() => import('../AdminUsuario/edit')),
  },
  {
    path: 'admin-fazenda',
    component: asyncComponent(() => import('../AdminFazenda')),
  },
  {
    path: 'admin-fazenda/new',
    component: asyncComponent(() => import('../AdminFazenda/new')),
  },
  {
    path: 'admin-fazenda/fazenda/:id',
    component: asyncComponent(() => import('../AdminFazenda/edit')),
  },
  {
    path: 'insumo/new',
    component: asyncComponent(() => import('../AdminFazenda/new')),
  },
];

class AppRouter extends Component {
  render() {
    const { url, style } = this.props;
    return (
      <div style={style}>
        {routes.map((singleRoute) => {
          const { path, exact, ...otherProps } = singleRoute;
          return (
            <Route
              exact={exact !== false}
              key={singleRoute.path}
              path={`${url}/${singleRoute.path}`}
              {...otherProps}
            />
          );
        })}
      </div>
    );
  }
}

export default AppRouter;
