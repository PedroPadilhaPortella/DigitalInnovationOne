<template>
    <div class="content">
        <List />
    </div>
</template>

<script>
import List from '../List/List.vue';

export default {
    name: 'LeftPanelContent', 
    components: { List },
}
</script>

<style>
    .content {
        width: 100%;
        
        @media(min-width: $viewport-medium) {
            margin-top: 50px;
        }
    }
</style>