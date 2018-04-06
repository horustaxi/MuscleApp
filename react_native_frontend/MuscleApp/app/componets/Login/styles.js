import EStyleSheet from 'react-native-extended-stylesheet';

export default EStyleSheet.create({
    logoContainer: {
        alignItems: 'center',
        flexGrow: 1,
        justifyContent: 'center'
    },
    logo: {
        width: 100,
        height: 100,
        borderRadius: 10,
    },
    title: {
        color: '$ptextColor',
        marginTop: 10,
        textAlign: 'center'
    },
    input: {
        height: 40,
        backgroundColor: '$plight',
        marginBottom: 20,
        paddingHorizontal: 10,
        color: '$ptextColor'
    },
    newAccountContainer: {
        flexDirection: 'row',
        justifyContent: 'flex-end',
        paddingTop: 10,
        marginRight: 5,
    },
    erroTextStyle: {
        fontSize: 20,
        alignSelf: 'center',
        color: 'red',
    }
});
