import React, {useContext, useEffect} from 'react'
import {LandingPageDiv, MainText, UserName} from "./LandingPageElements";
import AppContext from "../../context/AppContext";
import {fetchName} from "../../context/Actions";
import Loading from "../Loading";

function LandingPage() {

    const {state, dispatch} = useContext(AppContext);
    const {landingPage} = state;
    const {loggedUser} = state;
    const {loading, name} = landingPage;

    useEffect(() => {
        if (name === '') {
            fetchName(dispatch, loggedUser.id)
        }

    }, [])

    if (loading === true) {
        return (
            <Loading/>
        )
    }

    return (
        <>
            <LandingPageDiv>
                <MainText>
                    Welcome
                </MainText>
                <UserName>
                    {name}
                </UserName>
            </LandingPageDiv>
        </>
    )
}

export default LandingPage