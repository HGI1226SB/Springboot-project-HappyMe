import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { FiSend, FiArrowLeft } from 'react-icons/fi';

const About = () => {
    const navigate = useNavigate();
    const [formData, setFormData] = useState({
        name: '',
        email: '',
        message: ''
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData(prev => ({ ...prev, [name]: value }));
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log('Form Data Submitted:', formData);
        alert('Data stored in console! Check it out.');
    };

    const images = [
        'https://images.unsplash.com/photo-1470225620780-dba8ba36b745?auto=format&fit=crop&w=800&q=80',
        'https://images.unsplash.com/photo-1493225255756-d9584f8606e9?auto=format&fit=crop&w=800&q=80',
        'https://images.unsplash.com/photo-1459749411177-042180ceea72?auto=format&fit=crop&w=800&q=80'
    ];

    const videos = [
        'https://static.videezy.com/system/resources/previews/000/038/544/original/album-cover-art.mp4',
        'https://static.videezy.com/system/resources/previews/000/021/365/original/Music_Note_Animation.mp4',
        'https://static.videezy.com/system/resources/previews/000/052/357/original/Concert_Crowd.mp4'
    ];

    return (
        <div className="about-page" style={{ padding: '2rem', maxWidth: '1200px', margin: '0 auto' }}>
            <button className="btn btn-outline" onClick={() => navigate(-1)} style={{ marginBottom: '2rem' }}>
                <FiArrowLeft /> Back
            </button>

            <h1 className="font-heading" style={{ fontSize: '3.5rem', marginBottom: '1.5rem', textAlign: 'center', gradient: 'linear-gradient(to right, #fff, #888)' }}>
                About HappyMe
            </h1>

            <p style={{ fontSize: '1.2rem', color: 'var(--text-muted)', textAlign: 'center', marginBottom: '4rem', maxWidth: '800px', margin: '0 auto 4rem' }}>
                HappyMe is your personal haven for music and memories. We believe in the power of sound to transform your mood and elevate your spirit.
            </p>

            <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(300px, 1fr))', gap: '2rem', marginBottom: '4rem' }}>
                {images.map((img, i) => (
                    <div key={`img-${i}`} className="glass-card" style={{ height: '250px', overflow: 'hidden' }}>
                        <img src={img} alt={`Gallery ${i}`} style={{ width: '100%', height: '100%', objectFit: 'cover' }} />
                    </div>
                ))}
            </div>

            <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(300px, 1fr))', gap: '2rem', marginBottom: '4rem' }}>
                {videos.map((vid, i) => (
                    <div key={`vid-${i}`} className="glass-card" style={{ height: '250px', overflow: 'hidden' }}>
                        <video src={vid} autoPlay loop muted style={{ width: '100%', height: '100%', objectFit: 'cover' }} />
                    </div>
                ))}
            </div>

            <div className="content-section" style={{ marginBottom: '4rem', background: 'var(--card-bg)', padding: '3rem', borderRadius: '1rem' }}>
                <h2 className="font-heading" style={{ marginBottom: '1.5rem' }}>Our Mission</h2>
                <p style={{ color: 'var(--text-muted)', lineHeight: '1.8' }}>
                    Founded in 2024, HappyMe started as a simple idea: what if you could have a workspace that actually makes you happy?
                    Our platform integrates seamless music streaming with beautiful visual aesthetics to create the perfect flow state for our users.
                    Whether you're working, relaxing, or partying, HappyMe adapts to your rhythm.
                </p>
            </div>

            <div className="form-section login-card" style={{ maxWidth: '600px', margin: '0 auto' }}>
                <h2 className="font-heading" style={{ marginBottom: '2rem', textAlign: 'center' }}>Contact Us</h2>
                <form onSubmit={handleSubmit} style={{ display: 'flex', flexDirection: 'column', gap: '1.5rem' }}>
                    <input
                        type="text"
                        name="name"
                        placeholder="Your Name"
                        value={formData.name}
                        onChange={handleChange}
                        required
                    />
                    <input
                        type="email"
                        name="email"
                        placeholder="Your Email"
                        value={formData.email}
                        onChange={handleChange}
                        required
                    />
                    <textarea
                        name="message"
                        placeholder="Your Message..."
                        value={formData.message}
                        onChange={handleChange}
                        style={{
                            background: '#333',
                            border: 'none',
                            borderRadius: '4px',
                            padding: '1rem',
                            color: 'white',
                            minHeight: '150px',
                            fontFamily: 'inherit'
                        }}
                        required
                    />
                    <button type="submit" className="btn btn-primary" style={{ width: '100%' }}>
                        <FiSend /> Send Message
                    </button>
                </form>
            </div>
        </div>
    );
};

export default About;
