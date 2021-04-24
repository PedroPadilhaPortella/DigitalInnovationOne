<template>
    <div>
        <h1>Lista de Tarefas</h1>
        <input type="text" v-focus v-model="currentTask" @keyup.enter="addTask()"> <button @click="addTask()">Adicionar</button>
        <hr>
        <button @click="handleToggleList">Ver a Lista</button>

        <ul v-if="showList">
            <li v-for="(task, index) in tasks" :key="`${task}-${index}`" 
                @dblclick="complete(task)" :class="{'line-through' : task.isDone}" class="task-item"
            >
                {{ task.name }}
                <button @click="remove(task)">&times;</button>
            </li>
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
        currentTask: '',
        showList: true,
        tasks: [
            { name: 'Fazer o curso', isDone: false},
            { name: 'Estudar Alemão', isDone: false},
            { name: 'Fazer 30 flexões', isDone: false},
        ]
    }),
    methods: {
        addTask () {
            if(this.currentTask) {
                this.tasks.push({ name: this.currentTask, isDone: false })
                this.currentTask = ''
            }
        },
        handleToggleList () {
            this.showList = !this.showList
        },
        remove (task) {
            this.tasks = this.tasks.filter(t => t.name !== task.name)
        },
        complete (task) {
            this.tasks = this.tasks.map(t => {
                if(t.name === task.name) {
                    return { ...t, isDone: !t.isDone }
                }
                return { ...t }
            })
        }
    }
}
</script>

<style scoped>
    .line-through {
        text-decoration: line-through;
    }
    .task-item {
        cursor: pointer;
    }
</style>