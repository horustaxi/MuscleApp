const options = [
  {
    key: 'personal-trainees',
    label: 'Alunos',
    leftIcon: '',
  },
  {
    key: 'anyone-workout-plans',
    label: 'Programas de Treinos',
    leftIcon: '',
  },
  {
    key: 'anyone-workout-plans',
    label: 'Exercícios',
    leftIcon: '',
  },
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
    ],
  },
];
export default options;
