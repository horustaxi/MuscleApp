import React from 'react';
import { LayoutContentWrapper } from './layoutWrapper.style';

export default ({ className, children, ...rest }) => (
  <LayoutContentWrapper
    className={
      className != null ? `${className} isoLayoutContentWrapper` : 'isoLayoutContentWrapper'
    }
    {...rest}
  >
    {children}
  </LayoutContentWrapper>
);
