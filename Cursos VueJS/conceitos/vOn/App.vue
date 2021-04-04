<template>
  <div id="app">
    <div>
        <button @click="count1++">Click {{ count1 }}</button>
        <button @click="increment">Click {{ count2}}</button>
        <button @click="increment2(2, $event)">Click {{ count3 }}</button>

        <hr>

        <input type="text" @input="text = $event" @change="text = $event" @keyup.enter="increment" @keyup="text = $event"> {{text}}
        
        <br><input type="text" @keyup.ctrl.67="increment2(2, $event)"> {{count3}}
        <br><button @click.ctrl="count1++">CTRL</button>
        
        <hr>

        <ListItem @increment="add"/>
        {{ count1 }}
     </div>
  </div>
</template>

<script>
import ListItem from './ListItem';

export default {
    name: 'App',
    components: { ListItem },
    data() {
        return {
            count1: 0,
            count2: 0,
            count3: 0,
            text: ''
        }
    },
    methods: {
        add (valor, event) {
            this.count1 += valor
            console.log(event)
        },
        increment (event) {
            console.log(event);
            this.count2++
        },
        increment2 (n, event) {
            console.log(event);
            this.count3 += n;
        }
    }

}
</script>

<style>
    #app {
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        height: 100vh;
    }
</style>