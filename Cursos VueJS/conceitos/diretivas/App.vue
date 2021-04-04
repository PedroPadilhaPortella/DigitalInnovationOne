<template>
    <div id="app">
        <h1 v-if="show">Diretiva v-if</h1>
        <h1 v-else>Diretiva v-else</h1>
        <h1 v-show="show">Diretiva v-show</h1>
        <br>
        <p v-if="state == 'loading'">Loading...</p>
        <p v-else-if="state == 'error'">Error</p>
        <p v-else-if="messages.length == 0">Sem dados disponíveis</p>
        <p v-else>{{ messages }}</p>
        <br>
        <a :href="url">Link Dinâmico</a>
        <hr>
        <h1 :class="{red, green}" class="static">Classes  Dinâmicas</h1>
        <h1 :class="{red: showRed, green: !showRed, blue}">Classes  Dinâmicas Condicionais</h1>
        <p style="color: red" :style="{fontSize: '50px', color: 'gold'}">Estilos Dinâmicas</p>
        <div :style="estilo">pedro portella</div>
        <p :propriedade='prop'>Propriedades Pessoais</p>
    </div>

</template>

<script>
export default {
    name: 'App',
    components: {},
    data() {
        return {
            show: true,
            state: '',
            messages: ['angular', 'react', 'vue'],
            url: 'https://www.google.com',
            red: 'red',
            green: 'green',
            blue: 'blue',
            showRed: false,
            estilo: { backgroundColor: 'green' },
            prop: 'Hello World'
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