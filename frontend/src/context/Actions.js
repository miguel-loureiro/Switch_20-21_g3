import { familyRelationsFA } from './Service'

/**
 * Insert functions for Service:
 * - Success function
 * - Error function
 *
 * Both functions should have as ARG the dispatcher
 */


export const FETCH_PROFILE_STARTED = 'FETCH_PROFILE_STARTED';
export const FETCH_PROFILE_SUCCESS = 'FETCH_PROFILE_SUCCESS';
export const FETCH_PROFILE_FAILURE = 'FETCH_PROFILE_FAILURE';
export const DO_NOTHING = 'DO_NOTHING';
export const UPDATE_NAME = 'UPDATE_NAME';
export const CHANGE_USER = 'CHANGE_USER';
export const LOGOUT = 'LOGOUT';
export const CHANGE_VIEW = 'CHANGE_VIEW';

/*

/***** PROFILE
export function fetchProfile(dispatch){
    dispatch(fetchProfileStarted());
    const id = 'tonyze@latinlover.com';
    //fetchProfileFromWS((res) => dispatch(fetchProfileSuccess(res)), (err) =>dispatch(fetchProfileFailure(err.message)), id);
}

export function fetchNewProfile(dispatch, id){
    dispatch(fetchProfileStarted());
    fetchProfileFromWS((res) => dispatch(fetchProfileSuccess(res)), (err) =>dispatch(fetchProfileFailure(err.message)), id);
}

// Uniformizar actions com pedidos fetch para poder utilizar com families, person etc...

export function fetchProfileStarted () {
    return {
        type: FETCH_PROFILE_STARTED,
    }
}


export function fetchProfileSuccess(profile) {
    return {
        type: FETCH_PROFILE_SUCCESS,
        payload:{
            data: profile
        }
    }
}

export function fetchProfileFailure(message) {
    return {
        type: FETCH_PROFILE_FAILURE,
        payload: {
            error: message
        }
    }
}
*/

export const FETCH_FAMILYRELATIONS_STARTED = 'FETCH_FAMILYRELATIONS_STARTED';
export const FETCH_FAMILYRELATIONS_SUCCESS = 'FETCH_FAMILYRELATIONS_SUCCESS';
export const FETCH_FAMILYRELATIONS_FAILURE = 'FETCH_FAMILYRELATIONS_FAILURE';

export function fetchFamilyRelationsFA(dispatch, familyId){
    dispatch(fetchFamilyRelationStarted());
    familyRelationsFA((res) => dispatch(fetchFamilyRelationsSuccess(res)), (err) => dispatch(fetchFamilyRelationsFailure(err.message)), familyId)
}

/***** FAMILY *******/

export function fetchFamilyRelationStarted(){
    return {
        type: FETCH_FAMILYRELATIONS_STARTED
    }
}

export function fetchFamilyRelationsSuccess(familyRelations){
    return {
        type: FETCH_FAMILYRELATIONS_SUCCESS,
        payload: {
            data: familyRelations
        }
    }
}

export function fetchFamilyRelationsFailure(message){
    return {
        type: FETCH_FAMILYRELATIONS_FAILURE,
        payload: {
            data: message
        }
    }
}



/* TENTATIVAS */

export function doNothing(){
    return {
        type: DO_NOTHING,
        payload: {
        }
    }
}

export function updateName(variable){
    return {
        type: UPDATE_NAME,
        payload: {
            data: variable
        }
    }
}

export function changeUser(dispatch, personID){
    return {
        type: CHANGE_USER,
        payload:{
            data: personID
        }
    }
}

export function logout(dispatch) {
    return {
        type: LOGOUT,
    }
}

export function changeView(value) {
    return {
        type: CHANGE_VIEW,
        payload: {
            mainView: value
        }
    }
}