// app.js
const apiUrl = 'http://localhost:3000/posts';

async function fetchPosts() {
    const response = await fetch(apiUrl);
    const posts = await response.json();
    const postsDiv = document.getElementById('posts');
    postsDiv.innerHTML = '';
    // 게시글 목록을 역순으로 정렬
    posts.reverse().forEach(post => {
        const postDiv = document.createElement('div');
        postDiv.className = 'post';
        postDiv.innerHTML = `
            <h3>${post.title}</h3>
            <p>${post.content}</p>
            <p><small>작성자: ${post.author} | ${new Date(post.date).toLocaleString()}</small></p>
            <button onclick="deletePost(${post.id})">삭제</button>
            <button onclick="showEditForm(${post.id})">수정</button>
            <div id="edit-${post.id}" class="edit-form">
                <input type="text" id="edit-author-${post.id}" value="${post.author}">
                <input type="text" id="edit-title-${post.id}" value="${post.title}">
                <textarea id="edit-content-${post.id}" rows="4" cols="50">${post.content}</textarea>
                <button onclick="editPost(${post.id})">저장</button>
                <button onclick="hideEditForm(${post.id})">취소</button>
            </div>
        `;
        postsDiv.appendChild(postDiv);
    });
}

async function addPost() {
    const author = document.getElementById('author').value;
    const title = document.getElementById('title').value;
    const content = document.getElementById('content').value;
    const response = await fetch(apiUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ author, title, content })
    });
    const newPost = await response.json();
    document.getElementById('author').value = '';
    document.getElementById('title').value = '';
    document.getElementById('content').value = '';
    fetchPosts();
}

async function deletePost(id) {
    await fetch(`${apiUrl}/${id}`, {
        method: 'DELETE'
    });
    fetchPosts();
}

function showEditForm(id) {
    const editDiv = document.getElementById(`edit-${id}`);
    editDiv.style.display = 'block';
}

function hideEditForm(id) {
    const editDiv = document.getElementById(`edit-${id}`);
    editDiv.style.display = 'none';
}

async function editPost(id) {
    const author = document.getElementById(`edit-author-${id}`).value;
    const title = document.getElementById(`edit-title-${id}`).value;
    const content = document.getElementById(`edit-content-${id}`).value;
    const response = await fetch(`${apiUrl}/${id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ author, title, content })
    });
    if (response.ok) {
        fetchPosts();
    } else {
        console.error('Failed to update post');
    }
}

document.addEventListener('DOMContentLoaded', fetchPosts);
