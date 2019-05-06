const options = [
  {
    key: 'admin',
    label: 'Administração',
    leftIcon: 'ion-key',
    children: [
      {
        key: 'admin-usuario',
        label: 'Usuários',
        leftIcon: '',
      },
      {
        key: 'admin-empresa',
        label: 'Empresas',
        leftIcon: '',
      },
      {
        key: 'admin-filial',
        label: 'Filiais',
        leftIcon: '',
      },
      {
        key: 'admin-fazenda',
        label: 'Fazendas',
        leftIcon: '',
      },
      {
        key: 'admin-cargo',
        label: 'Cargos',
        leftIcon: '',
      },
      {
        key: 'insumo',
        label: 'Insumos',
        leftIcon: 'ion-ios-list',
      },
    ],
  },
  {
    key: 'escala',
    label: 'Escala',
    leftIcon: 'ion-ios-list',
  },
  {
    key: 'ocorrencia',
    label: 'Ocorrência',
    leftIcon: 'ion-ios-gear',
  },
  {
    key: 'apontamentos',
    label: 'Apontamentos',
    leftIcon: 'ion-ios-list',
    children: [
      {
        key: 'aplicacao-insumo',
        label: 'Aplicações de Insumo',
        leftIcon: 'ion-ios-list',
      },
      {
        key: 'apontamento-chuva',
        label: 'Apontamentos de Chuva',
        leftIcon: 'ion-ios-list',
      },
      {
        key: 'apontamento-area',
        label: 'Apontamentos de Área',
        leftIcon: 'ion-ios-list',
      },
      {
        key: 'apontamento-area-preparo',
        label: 'Apontamentos de Área de Preparo',
        leftIcon: 'ion-ios-list',
      },
      {
        key: 'apontamento-atividade-mecanizada',
        label: 'Apontamentos de Atividade Mecanizada',
        leftIcon: 'ion-ios-list',
      },
      {
        key: 'apontamento-atividades-manuais',
        label: 'Apontamentos de Atividades Manuais',
        leftIcon: 'ion-ios-list',
      },
      {
        key: 'apontamento-combustivel',
        label: 'Apontamentos de Combustível',
        leftIcon: 'ion-ios-list',
      },
      {
        key: 'apontamento-lubrificante',
        label: 'Apontamentos de Lubrificante',
        leftIcon: 'ion-ios-list',
      },
      {
        key: 'apontamento-moagem-diaria',
        label: 'Apontamentos de Moagem Diária',
        leftIcon: 'ion-ios-list',
      },
      {
        key: 'apontamento-plantio',
        label: 'Apontamentos de Plantio',
        leftIcon: 'ion-ios-list',
      },
      {
        key: 'apontamento-terceiros-mecanizado',
        label: 'Apontamentos de Terceiros Mecanizado',
        leftIcon: 'ion-ios-list',
      },
      {
        key: 'fechamento-corte',
        label: 'Fechamentos de Corte',
        leftIcon: 'ion-ios-list',
      },
      {
        key: 'ordem-corte',
        label: 'Ordens de Corte',
        leftIcon: 'ion-ios-list',
      },
      {
        key: 'ordem-servico',
        label: 'Ordens de Serviço',
        leftIcon: 'ion-ios-list',
      },
    ],
  },
  {
    key: 'maps',
    label: 'Maps',
    leftIcon: 'ion-map',
    children: [
      {
        key: 'mapas',
        label: 'Importação de Mapas',
        leftIcon: '',
      },
    ],
  },
];
export default options;
