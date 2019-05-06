import React from 'react';
import BoxTitleWrapper from './boxTitle';
import { BoxWrapper } from './box.style';

export default ({ title, subtitle, children }) => (
  <BoxWrapper className="isoBoxWrapper">
    <BoxTitleWrapper title={title} subtitle={subtitle} />
    {children}
  </BoxWrapper>
);
