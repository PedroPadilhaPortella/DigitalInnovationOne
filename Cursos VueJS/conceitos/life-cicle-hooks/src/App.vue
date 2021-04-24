<template>
<div>
    <h1>Life Cicle Hooks</h1>
    <p>Principais LifeCycle Hooks</p>
    <ul>
        <li>beforeEach (colocar fora do setup())</li>
        <li>created (coloca diretamente no setup)</li>
        <li>beforeMount / onBeforeMount</li>
        <li>mounted / onMounted</li>
        <li>beforeUpdate / onBeforeUpdate</li>
        <li>updated / onUpdated</li>
        <li>beforeUnmount / onBeforeUnmount</li>
        <li>unmounted / onUnmounted</li>
        <li>errorCaptured / onErrorCaptured</li>
        <li>renderTracked / onRenderTracked</li>
        <li>renderTriggered / onRenderTriggered</li>
    </ul>
</div>
</template>

<script>
import { onMounted } from 'vue';

export default {
 setup () {
     onMounted (() => console.log('Component foi montado (composition api)'))
 }
/*
    mounted () {
        console.log("Componente foi montado. (options api)")
    }
*/
}
</script>
<style>

</style>