<template>
  <div id="app">
    <input type="text" @input="text = $event.target.value" :value="text"  />
    <input type="text" v-model.trim="text"  />
    <input type="number" v-model.number="n"  />
    {{ text }}    {{ n }}
    <hr>
    <input type="checkbox" v-model="check">
    {{ check }}
    <Input v-model="inputString" /> {{ inputString }}
  </div>
</template>

<script>
import Input from './Input';
export default {
    name: 'App',
    components: { Input },
    data() {
        return {
            text: '',
            check: false,
            n: 0,
            inputString: ''
        };
    },
    watch: {
        text(value) {
            console.log(value);
        }
    }
}
</script>

<style>
    * {
        margin: 0;
        padding: 0;
    }
    #app {
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        height: 100vh;
    }
    input {
        margin: 0.5rem;
    }
</style>