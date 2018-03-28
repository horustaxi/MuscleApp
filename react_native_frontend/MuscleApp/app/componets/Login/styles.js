import EStyleSheet from 'react-native-extended-stylesheet';

export default EStyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '$plight'
    },
    logoContainer: {
        alignItems: 'center',
        flexGrow: 1,
        justifyContent: 'center'
    },
    logo: {
        width: 100,
        height: 100
    },
    title: {
        color: '$ptextColor',
        marginTop: 10,
        textAlign: 'center'
    },
    formContainer: {
        flex: 1,
        padding: 20
    },
    input: {
        height: 40,
        backgroundColor: '$plight',
        marginBottom: 20,
        paddingHorizontal: 10,
        color: '$ptextColor'
    }
});
