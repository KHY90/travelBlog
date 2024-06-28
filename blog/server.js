// server.js
const express = require('express');
const bodyParser = require('body-parser');
const cors = require('cors');
const fs = require('fs');
const path = require('path');

const app = express();
const PORT = 3000;
const DATA_FILE = path.join(__dirname, 'posts.json');

app.use(bodyParser.json());
app.use(cors());

const readPostsFromFile = () => {
    if (fs.existsSync(DATA_FILE)) {
        const data = fs.readFileSync(DATA_FILE, 'utf-8');
        return JSON.parse(data);
    }
    return [];
};

const writePostsToFile = (posts) => {
    fs.writeFileSync(DATA_FILE, JSON.stringify(posts, null, 2));
};

let posts = readPostsFromFile();

app.get('/posts', (req, res) => {
    res.json(posts);
});

app.post('/posts', (req, res) => {
    const post = req.body;
    post.id = Date.now();
    post.date = new Date().toISOString();
    posts.push(post);
    writePostsToFile(posts);
    res.status(201).json(post);
});

app.delete('/posts/:id', (req, res) => {
    const id = parseInt(req.params.id);
    posts = posts.filter(post => post.id !== id);
    writePostsToFile(posts);
    res.status(204).end();
});

app.put('/posts/:id', (req, res) => {
    const id = parseInt(req.params.id);
    const updatedPost = req.body;
    const postIndex = posts.findIndex(post => post.id === id);
    if (postIndex !== -1) {
        posts[postIndex] = { ...posts[postIndex], ...updatedPost, id, date: posts[postIndex].date };
        writePostsToFile(posts);
        res.status(200).json(posts[postIndex]);
    } else {
        res.status(404).json({ message: 'Post not found' });
    }
});

app.listen(PORT, () => {
    console.log(`Server is running on http://localhost:${PORT}`);
});
