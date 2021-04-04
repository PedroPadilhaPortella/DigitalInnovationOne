<template>
    <div>
        <h1 v-bind="$attrs">{{ titulo }}</h1>
        <h3>{{ subtitulo }}</h3>
        <p>Nota: {{ nota }}</p>
        <span>Tipo: {{ tipo }}</span>
    </div>
</template>

<script>
export default {
    name: 'Title',
    inheritAttrs: false,
    props: { 
        titulo: {
            type: String,
            required: true
        },
        subtitulo: {
            type: String,
            required: false,
            default: 'lorem ipsum devaus duspesar'
        },
        nota: {
            type: Number,
            required: true
        },
        tipo: {
            type: Number,
            default: 3,
            validator(value) {
                return [1, 2, 3].includes(value)
            }
        }
    },
    data () {
        return {
            
        }
    }

}
</script>

<style>

</style>