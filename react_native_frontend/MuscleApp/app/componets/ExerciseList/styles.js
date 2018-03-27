import EStyleSheet from 'react-native-extended-stylesheet';

export default EStyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '$plight',
        justifyContent: 'flex-start',
        alignItems: 'center'
    },
    textStyle: {
        height: 40,
        backgroundColor: '$plight',
        marginBottom: 20,
        marginTop: 20,
        paddingHorizontal: 10,
        color: '$ptextColor'
    },
});
