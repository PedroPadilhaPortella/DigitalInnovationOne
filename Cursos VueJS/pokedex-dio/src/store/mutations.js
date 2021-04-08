import state from './state';

export default {
    //Update the pokedex loading offset
    updateOffset() {
        state.offset += state.limit;
    },

    //Adds pokemons to the pokedex for the infinite loading
    setList(list) {
        state.list.push(...list);
        state.tmpList.push(...list);
    },

    //Informs if the pokedex needs more data
    setListHasNext(flag) {
        state.listHasNext = flag;
    },

    //Informs if the pokedex has finished fetching data
    setListHasCompleted(flag) {
        state.listHasCompleted = flag;
    },

    //Informs if the pokedex got an error
    setListHasError(flag) {
        state.listHasError = flag;
    },

    //Resets the pokedex to the last cache and removes search information
    resetList() {
        state.list = [...state.tmpList];
        state.isPokemonSearch = false;
        state.listHasError = false;
        state.searchHasError = false;
    }
}