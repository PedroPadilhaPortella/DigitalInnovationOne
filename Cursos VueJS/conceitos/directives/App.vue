<template>
    <div>
        <h1>Lista de Tarefas</h1>
        <input type="text" v-focus><hr>
        <button @click="() => showList = !showList">Ver a Lista</button>
        <ul v-if="showList">
            <li v-for="(task, index) in tasks" :key="`${task}-${index}`">{{ task.name }}</li>
        </ul>
        <p v-else>Lista de tarefas escondidas</p>
    </div>
</template>

<script>
const focus = {
    inserted: (el) => {
        el.focus()
    }
}

export default {
    directives: {
        focus
    },
    data: () => ({
        showList: true,
        tasks: [
            { name: 'Fazer o curso', isDone: false},
            { name: 'Estudar Alemão', isDone: false},
            { name: 'Fazer 30 flexões', isDone: false},
        ]
    })
}
</script>