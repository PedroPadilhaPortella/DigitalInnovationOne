<template>
    <div>
        <h1>Lista de Tarefas</h1>
        <input
            type="text"
            v-focus
            v-model="state.currentTask"
            @keyup.enter="addTask()"
        />
        <button @click="addTask()">Adicionar</button>
        <hr />
        <button @click="handleToggleList">Ver a Lista</button>

        <ul v-if="state.showList">
            <li
                v-for="(task, index) in state.tasks"
                :key="`${task}-${index}`"
                @dblclick="complete(task)"
                :class="{ 'line-through': task.isDone }"
                class="task-item"
            >
                {{ task.name }}
                <button @click="remove(task)">&times;</button>
            </li>
        </ul>
        <p v-else>Lista de tarefas escondidas</p>
    </div>
</template>

<script>

import { reactive } from 'vue';

const focus = {
    inserted: (el) => {
        el.focus();
    },
};

export default {
    directives: {
        focus,
    },
    setup() {
        const state = reactive({
            currentTask: "",
            showList: true,
            tasks: [
                { name: "Fazer o curso", isDone: false },
                { name: "Estudar Alemão", isDone: false },
                { name: "Fazer 30 flexões", isDone: false },
            ],
        });
        function addTask() {
            if (state.currentTask) {
                state.tasks.push({ name: state.currentTask, isDone: false });
                state.currentTask = "";
            }
        }
        function handleToggleList() {
            state.showList = !state.showList;
        }
        function remove(task) {
            state.tasks = state.tasks.filter((t) => t.name !== task.name);
        }
        function complete(task) {
            state.tasks = state.tasks.map((t) => {
                if (t.name === task.name) {
                    return { ...t, isDone: !t.isDone };
                }
                return { ...t };
            });
        }
        return { state, addTask, handleToggleList, remove, complete };
    },
};
</script>

<style scoped>
.line-through {
    text-decoration: line-through;
}
.task-item {
    cursor: pointer;
}
</style>