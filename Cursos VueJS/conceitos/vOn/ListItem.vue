<template>
    <div>
        <li @click="$emit('increment', 5, $event)">Clique aqui</li>
        <li @click="emit">Clique aqui 2</li>
    </div>
</template>

<script>
export default {
    name: 'ListItem',
    methods: {
        emit(event) {
            this.$emit('increment', 5, event)
        }
    }
}
</script>

<style>

</style>