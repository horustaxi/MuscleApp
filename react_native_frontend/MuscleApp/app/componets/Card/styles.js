import EStyleSheet from 'react-native-extended-stylesheet';

export default EStyleSheet.create({
    textStyle: {
        color: '$ptextColor'
    },
    cardStyle: {
        borderWidth: 1,
        borderRadius: 2,
        borderColor: '$pdark',
        borderBottomWidth: 0,
        shadowColor: '#000',
        shadowOffset: { width: 0, height: 2 },
        shadowOpacity: 0.1,
        shadowRadius: 2,
        elevation: 1,
        marginLeft: 5,
        marginRight: 5,
        marginTop: 10,
    },
    cardSectionStyle: {
        borderBottomWidth: 1,
        padding: 5,
        backgroundColor: '$plight',
        justifyContent: 'flex-start',
        flexDirection: 'row',
        borderColor: '$pdark',
        position: 'relative',
    }
});
