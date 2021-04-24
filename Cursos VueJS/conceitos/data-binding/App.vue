<template>
    <div>
        <h1 :style="{ textDecoration: decoration }">Hello VueJS</h1>
        <p>Author: {{ name }}</p>
        <input type="text" v-model="name">
        <br>
        <a :href="link">Link do Curso</a>
    </div>
</template>

<script>
export default {
    data: () => ({
        name: 'Pedro Portella',
        decoration: 'underline',
        link: 'https://igorhalfeld.teachable.com/courses/enrolled/1283923'
    })
}
</script>