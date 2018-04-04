import EStyleSheet from 'react-native-extended-stylesheet';

export default EStyleSheet.create({
    // container: {
    //     flex: 1,
    //     backgroundColor: '$plight',
    //     justifyContent: 'flex-start',
    // },
    textStyle: {
        color: '$ptextColor',
        fontSize: 18,
    },
    headerContentStyle: {
        flex: 1,
        flexDirection: 'column',
        justifyContent: 'space-around',
    },
    imageStyle: {
        width: 50,
        height: 50,
    },
    imageContainerStyle: {
        justifyContent: 'center',
        alignItems: 'center',
        marginLeft: 10,
        marginRight: 10,
    }
});
