from flask import Flask, request, jsonify
from transformation import transform_legacy_data

app = Flask(__name__)

# Health check or default route for browser testing
@app.route('/')
def home():
    return '✅ Flask Data Modernization API is running at /transform (POST only)'

# Core API endpoint for transformation
@app.route('/transform', methods=['POST'])
def transform():
    try:
        data = request.get_json()
        legacy_data = data.get("legacy_data")

        if not legacy_data:
            return jsonify({"error": "Missing 'legacy_data' in request"}), 400

        modernized = transform_legacy_data(legacy_data)
        return jsonify({"modernized_data": modernized}), 200

    except Exception as e:
        return jsonify({"error": str(e)}), 500

if __name__ == "__main__":
    app.run(port=5001)
