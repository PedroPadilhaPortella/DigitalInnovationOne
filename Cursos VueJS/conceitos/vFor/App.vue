<template>
    <div id="app">
        <ol>
            <li v-for="(value, key, index) in todos" :key="key">{{ value }}: {{ key }} - {{ index }}</li>
        </ol><hr>
        <ul>
            <li v-for="(char, index) in text" :key="index">{{ char }} ({{ index }})</li>
        </ul><hr>
        <ul>
            <span v-for="numero in 10" :key="numero">{{ numero }}, </span>
        </ul><hr>
        <ul>
            <template v-if="filteredTodos.length > 0">
                <li v-for="(todo, i) in filteredTodos" :key="i">{{ todo }}</li>
            </template>
            <li v-else>No items</li>
        </ul>
    </div>
</template>

<script>

export default {
    name: 'App',
    data () {
        return {
            todos: {
                item1: 'Pão',
                item2: 'Batata',
                item3: 'Suco de Uva Integral',
                item4: 'Maçãs',
            },
            text: 'Hello World VueJS',
            to_do: [
                {label: 'fazer pão', isCompleted: true},
                {label: 'estudar alemão', isCompleted: false},
                {label: 'dormir', isCompleted: true},
                {label: 'orar', isCompleted: false},
            ]
        }
    },
    computed: {
        filteredTodos () {
            return this.to_do.filter(todo => !todo.isCompleted)
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