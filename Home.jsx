import React from 'react';

const Home = ({ user }) => {
    return (
        <div style={{ textAlign: 'center', padding: '50px' }}>
            <h1>Welcome to HappyMe, {user.username}!</h1>
            <p>You have successfully logged in using 2-step verification.</p>
            <button
                onClick={() => window.location.href = '/login'}
                style={{
                    padding: '10px 20px',
                    backgroundColor: '#4f46e5',
                    color: 'white',
                    border: 'none',
                    borderRadius: '5px',
                    cursor: 'pointer'
                }}
            >
                Logout
            </button>
        </div>
    );
};

export default Home;
