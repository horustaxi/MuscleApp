import React from 'react';
import { ComponentTitleWrapper } from './pageHeader.style';

export default ({ children }) => (
  <ComponentTitleWrapper className="isoComponentTitle">{children}</ComponentTitleWrapper>
);
