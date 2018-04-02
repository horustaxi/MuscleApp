import EStyleSheet from 'react-native-extended-stylesheet';

export default EStyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '$plight',
        justifyContent: 'flex-start',
    },
    textStyle: {
        color: '$ptextColor'
    },
    headerContentStyle: {
        flexDirection: 'column',
        justifyContent: 'space-around',
    }
});
