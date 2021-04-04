<template>
    <div id="app">
        <Title style="color: red" x="y" class="red" titulo="Curso Básico de VueJS" subtitulo="Curso disponivel no site da DIO" :nota="7"/>
        <Title style="color: blue" y="x" class="blue" titulo="Curso Básico de ReactNative" :nota="6" :tipo="1"/>
        <Title v-bind="titulos[0]"/>
    </div>
</template>

<script>
import Title from './Title';

export default {
    name: 'App',
    components: { Title },
    data () {
        return {
            titulo: 'Passagem de dados com Propriedades',
            subtitulo: 'Aula para explicar como funciona a passagem de propriedades entre componentes',
            titulos: [ { titulo: 'Titulo', subtitulo: 'Subtitulo', tipo: 1, style: 'color: green', z: "x+y" } ]
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