<template>
    <div>
        <h1>Custom Input</h1>
        <input type="text" @input="$emit('input', $event.target.value)" :value="value"/>
    </div>
</template>

<script>
export default {
    name: 'Input',
    props: ['value']
}
</script>