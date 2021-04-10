import pokeapi from '../services/pokeapi';
import state from './state';
import mutations from './mutations';

export default {
    async getPokemons() {
        const {setList, setIsPokemonSearch, setListHasError, setListHasNext, setListHasCompleted, updateOffset} = mutations;
    
        try {
            setIsPokemonSearch(false);
            setListHasError(false);

            const pokemonsList = await pokeapi.getPokemons({ limit: state.limit, offset: state.offset });

            if(pokemonsList?.results?.length) {
                const prepareInfo = pokemonsList.results.map(item => pokeapi.getPokemonByName(item.name));
                const pokemonsInfo = await Promise.all(prepareInfo);
                setList(pokemonsInfo);
            }

            if(pokemonsList?.next) {
                setListHasNext(true);
                updateOffset();
            } else {
                setListHasNext(false);
                setListHasCompleted(true);
            }

        } catch (err) {
            setListHasError(true);
        }
    },

    async getPokemonByName(name) {
        const { setPokemonSearched } = mutations;
        const pokemon = await pokeapi.getPokemonByName(name);
        if(pokemon) setPokemonSearched(pokemon);
    },

    async searchPokemon(name) {
        const { setIsPokemonSearch, setIsSearching, setPokemonSearched, resetList, setSearchHasError } = mutations;
        
        if(!name) {
            resetList();
            return; //*********** */
        }
        
        try {
            setSearchHasError(false);
            setIsSearching(true);
            setIsPokemonSearch(true);
            
            const pokemon = state.tmpList.find(info => info.name.toLowerCase() === name.toLowerCase());
            
            if(pokemon) {
                setPokemonSearched(pokemon);
                return;
            }

            await this.getPokemonByName(name);
            
        } catch( err) {
            setSearchHasError(true);
        } finally {
            setIsSearching(false);
        }
    }
}