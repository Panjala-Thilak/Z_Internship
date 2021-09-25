function firstFun(){
    const firstName="thanuja"
    const city="knr"
    secondFun()
    function secondFun(){
        const firstName="thilak"
        console.log(`${firstName} lives in ${city}`)
    }
}

firstFun()